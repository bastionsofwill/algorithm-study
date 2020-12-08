import collections

def solution(participant, completion):
    counter_participant = collections.Counter(participant)
    counter_completion = collections.Counter(completion)
    return list((counter_participant - counter_completion).keys())[0]

print(solution(["leo", "kiki", "eden"], ["kiki", "eden"]))