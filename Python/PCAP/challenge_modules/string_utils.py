import math
def halve_string(input_string):
    return (input_string[:math.ceil(len(input_string)/2)], input_string[math.ceil(len(input_string)/2):])

# print(halve_string("Hello0"))