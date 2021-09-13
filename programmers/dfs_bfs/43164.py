def find_route(tickets, departure):
    if len(tickets) == 1:
        return [tickets[0][0], tickets[0][1]] if tickets[0][0] == departure else []
    else:
        for ticket_idx in range(len(tickets)):
            dep, arr = tickets[ticket_idx]
            if dep == departure:
                tickets_left = tickets[:ticket_idx] + tickets[ticket_idx + 1:]
                routes_to_go = find_route(tickets_left, arr)
                if len(routes_to_go) == len(tickets_left) + 1:
                    return [dep] + routes_to_go
        return []

def solution(tickets):
    answer = []
    tickets.sort()
    for ticket_idx in range(len(tickets)):
        dep, arr = tickets[ticket_idx]
        if dep == "ICN":
            answer = [dep] + find_route(tickets[:ticket_idx] + tickets[ticket_idx + 1:], arr)
            if len(answer) == len(tickets) + 1:
                return answer

tickets =[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
print(solution(tickets))
# ["ICN", "JFK", "HND", "IAD"]