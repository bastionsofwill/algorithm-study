def calc_fee(parked_time, fees):
    base_time, base_fee, unit_time, unit_fee = fees
    if parked_time <= base_time:
        return base_fee
    else:
        q, r = divmod((parked_time - base_time), unit_time)
        c = 0 if r == 0 else 1 
        return base_fee + (q + c)*unit_fee

def solution(fees, records):
    car_dict = {}
    for r in records:
        t, id, io = r.split()
        hh, mm = map(int, t.split(':'))
        t_now = hh*60 + mm
        if id not in car_dict:
            car_dict[id] = [0, t_now]
        elif car_dict[id][1] == -1:
            car_dict[id][1] = t_now
        else:
            car_dict[id][0] += t_now - car_dict[id][1]
            car_dict[id][1] = -1
    cars = sorted(car_dict.items())
    answer = []
    
    for id, stat in cars:
        if stat[1] != -1:
            stat[0] += (23*60 + 59 - stat[1])
        print(stat)
        answer.append(calc_fee(stat[0], fees))
    return answer

fees = [1, 461, 1, 10]
records = ["00:00 1234 IN"]

print(solution(fees, records))