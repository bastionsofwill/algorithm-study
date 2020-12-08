people = [70, 50, 80, 100, 34, 33, 55, 45]
limit = 100

boatcount = 0

people_sorted = sorted(people, reverse = True)
people_onboard = [False]*len(people_sorted)
for person_idx in range(len(people_sorted)):
    is_alone = True
    if not(people_onboard[person_idx]):
        for shotgun_idx in range(person_idx + 1, len(people_sorted)):
            if not(people_onboard[shotgun_idx]) and (people_sorted[person_idx] + people_sorted[shotgun_idx] <= limit):
                people_onboard[person_idx] = True
                people_onboard[shotgun_idx] = True
                boatcount += 1
                is_alone = False
                break
        if is_alone:
            people_onboard[person_idx] = True
            boatcount += 1
    
print(boatcount)