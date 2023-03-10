from Guid import Contact as con


class PhoneBook:
    phone_book = []

    def get_phone_book(self):
        return self.phone_book

    def set_phone_book(self, phone_book):
        self.phone_book = phone_book

    def add_contact(self, list_):
        self.phone_book.append(con.Contact(list_[0], list_[1], list_[2]))

    def delete_contact(self, phone):
        if len(self.phone_book) > 0:
            for i, name in enumerate(self.phone_book):
                if phone in str(name.num_phone):
                    confirm = input(f'Вы действительно хотите удалить контакт {name.name}?(y/n) -> ')
                    if confirm.lower() == 'y':
                        del self.phone_book[i]
                        return True
                    return False

    def find_contact(self, search):
        count = 0
        for id, name in enumerate(self.phone_book, 1):
            if (search in name.name) or (search in name.num_phone) or (search in name.comment):
                    print()
                    print(id, name)
                    count += 1
        if count == 0:
            print('\nТакого словосочетания нет ни в одних полях книги.')

    def change_contact(self, list_):
        for i, name in enumerate(self.phone_book, 0):
            if i == list_[0] - 1:
                del self.phone_book[i]
                self.phone_book.insert(i, con.Contact(list_[1], list_[2], list_[3]))


p_b = PhoneBook()



