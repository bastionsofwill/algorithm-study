def solution(id_list, report, k):
    answer = []
    report_dict = {}
    mail_dict = {}
    for id in id_list:
        mail_dict[id] = 0
    for r in report:
        er, ed = r.split()
        if ed in report_dict:
            report_dict[ed].add(er)
        else:
            report_dict[ed] = set([er])
    for ed, er_set in report_dict.items():
        if len(er_set) >= k:
            for er in er_set:
                mail_dict[er] += 1
    for id in id_list:
        answer.append(mail_dict[id])            
    return answer

id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]

print(solution(id_list, report, 2))