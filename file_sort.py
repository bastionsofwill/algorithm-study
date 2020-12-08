def solution(files):
    answer = []
    return answer

file_list = ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG", "MUZI01.zip", "muzi1.png"]
file_parsed = []
file_head_lowercase = []
file_index = 0
sorted_files = []
for file_name in file_list:
    head_flag = True
    head_string = ""
    number_string = ""
    tail_string = ""
    for letter in file_name:
        if not(letter.isdecimal()) and head_flag:
            head_string += letter
        elif letter.isdecimal():
            number_string += letter
            head_flag = False
        else:
            tail_string += letter
    file_number = int(number_string)
    head_string_lowercase = head_string.lower()
    file_parsed.append((file_index, head_string, file_number, tail_string))
    file_head_lowercase.append((head_string_lowercase, file_number, file_index))
    file_index += 1

sorted_list = sorted(file_head_lowercase, key = lambda x: (x[0], x[1]))
for file_name in sorted_list:
    for file_name2 in file_parsed:
        if file_name[2] == file_name2[0]:
            sorted_files.append(file_name2[1]+str(file_name2[2])+file_name2[3])
print(sorted_files)