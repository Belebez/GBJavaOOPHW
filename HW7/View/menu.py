from DB import data_base as db
from Guid import PhoneBook as PB
from View import console_view as cv

def main_menu(choice: int):
    match choice:
        case 1:
            phone_book = PB.p_b.get_phone_book()
            cv.show_phone_book(phone_book)
        case 2:
            db.read_data_base()
            cv.download_completed()
        case 3:
            db.save_phone_book()
            cv.save_completed()
        case 4:
            contact = cv.input_new_contact()
            PB.p_b.add_contact(contact)
        case 5:
            PB.p_b.change_contact(cv.input_change_contact())
            cv.change_completed()
        case 6:
            phone_book = PB.p_b.get_phone_book()
            cv.show_phone_book(phone_book)
            phone = cv.input_delete_contact()
            if PB.p_b.delete_contact(phone):
                cv.delete_completed()
        case 7:
            search = cv.input_find_contact()
            PB.p_b.find_contact(search)
        case 0:
            return True


def start():
    while True:
        choice = cv.main_menu()
        if main_menu(choice):
            cv.log_off()
            break
