from random import choice

if __name__ == '__main__':
    
    instruction_txt = "--Password generator--\nChoose option:\n1) Generate password\n2) Exit\n"
    uppercase = [chr(k) for k in range(65, 91)]
    lowercase = [chr(k) for k in range(97, 123)]
    numbers = [str(k) for k in range(0, 10)]
    special_chars = ['!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '|']

    while True:
        print(instruction_txt)
        try:
            k = int(input("Your choice: "))
            
            if k != 1:
                if k == 2:
                    print("Bye!")
                    exit()
                print("Please enter a correct value")
                continue

            size = int(input("Provide password length: "))
            uc = input("Use uppercase letters? (y/n): ")
            dt = input("Use digits? (y/n): ")
            sc = input("Use special characters? (y/n): ")
            password = ""
            master_list = [lowercase]
            if uc == 'y':
                master_list.append(uppercase)
            if dt == 'y':
                master_list.append(numbers)
            if sc == 'y':
                master_list.append(special_chars)
            
            for i in range(size):
                password += choice(choice(master_list))
            
            print()
            print("Generated password: " + password)
            print()

        except Exception as e:
            print(str(e))

        
    