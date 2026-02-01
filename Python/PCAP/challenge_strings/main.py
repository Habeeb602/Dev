sample_story = '''Once upon a time, there was a beginner programmer named Alice who was eager to learn Python. She tried to learn from books, but found it difficult to grasp the concepts. One day, she stumbled upon an online course.

Alice was thrilled. The course was taught by a well-known programmer who made the lessons interesting and easy to understand. The course covered everything a beginner programmer needed, and Alice was finally able to understand how to code in Python.'''

def get_longest_word(input_string):
    input_string = input_string.replace(",", "").replace(".", "").split()
    longest_word = ""
    for k in input_string:
        if len(k) > len(longest_word):
            longest_word = k
    print(longest_word)
get_longest_word(sample_story)