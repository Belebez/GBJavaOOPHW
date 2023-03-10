
class Contact:
    def __init__(self, name, num_phone, comment):
        self.__name = name
        self.__num_phone = num_phone
        self.__comment = comment

    def get_contact(self):
        return self.__name, self.__num_phone, self.__comment

    # используем декоратор, для улучшения работы с геттерами и сеттарами,
    # вместо этого можно просто брать объект класса и выводить и устанавливать нужные значения
    # например - Ivan = Contact('Ivan', '1234567890', 'comment'), Ivan.name = Vasiliy, так мы установим новое значение
    # вместо написания Ivan.set_name('Vasiliy')

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, name):
        self.__name = name

    @property
    def num_phone(self):
        return self.__num_phone

    @num_phone.setter
    def num_phone(self, num_phone):
        self.__num_phone = num_phone

    @property
    def comment(self):
        return self.__comment

    @comment.setter
    def comment(self, comment):
        self.__comment = comment

    def __repr__(self):
        return str(self)

    def __str__(self):
        return f'{self.__name} {self.__num_phone} {self.__comment}'
