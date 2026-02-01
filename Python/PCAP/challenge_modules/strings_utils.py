from string_utils import halve_string

def halve_strings(input_string_list):
    res = []
    for string in input_string_list:
        res.append(halve_string(string))
    return res
