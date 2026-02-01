import random

def generate_tickets(ticket_count, max_number):
    ans = random.sample([i for i in range(0, max_number)], ticket_count)
    return (ans, random.choice(ans))


print(generate_tickets(30, 500))