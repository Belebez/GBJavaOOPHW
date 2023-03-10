from Guid import PhoneBook as pb
from Guid import Contact as con


path = 'phone_book.txt'

def read_data_base():
    with open(path, 'r', encoding='UTF-8') as file:
        phone_book = file.readlines()
    pb.p_b.set_phone_book(str_to_list(phone_book))

def str_to_list(phone_book: list):
    new_phone_book = []
    for contact in phone_book:
        new_contact = contact.strip().split(';')
        new_phone_book.append(con.Contact(new_contact[0], new_contact[1], new_contact[2]))
    return new_phone_book

def save_phone_book():
    with open(path, 'w', encoding='UTF-8') as file:
        file.write(list_to_str())

def list_to_str():
    new_phone_book = []
    phone_book = pb.p_b.get_phone_book()
    for contact in phone_book:
        new_phone_book.append(';'.join(str(contact).split()) + '\n')
    return ''.join(new_phone_book)
