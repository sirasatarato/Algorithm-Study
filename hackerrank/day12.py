class Person:
    def __init__(self, firstName, lastName, idNumber):
        self.firstName = firstName
        self.lastName = lastName
        self.idNumber = idNumber
    def printPerson(self):
        print("Name:", self.lastName + ",", self.firstName)
        print("ID:", self.idNumber)

from statistics import mean

class Student(Person):
    def __init__(self, firstName, lastName, idNumber, socores):
        self.firstName = firstName
        self.lastName = lastName
        self.idNumber = idNumber
        self.scores = scores


    def calculate(self):
        value = mean(self.scores)
        if 90 <= value <= 100:
            return "O"
        elif 80 <= value < 90:
            return "E"
        elif 70 <= value < 80:
            return "A"
        elif 55 <= value < 70:
            return "P"
        elif 40 <= value < 55:
            return "D"
        elif value < 40:
            return "T"


line = input().split()
firstName = line[0]
lastName = line[1]
idNum = line[2]
numScores = int(input()) # not needed for Python
scores = list( map(int, input().split()) )
s = Student(firstName, lastName, idNum, scores)
s.printPerson()
print("Grade:", s.calculate())