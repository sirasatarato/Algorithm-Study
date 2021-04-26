class AdvancedArithmetic(object):
    def divisorSum(n):
        raise NotImplementedError

class Calculator(AdvancedArithmetic):
    def divisorSum(self, n):
        i = 1
        s = 0

        while(True):
            if i * i >= n:
                break

            if n % i == 0:
                s += i
                s += int(n / i)

            i += 1

        if i * i == n:
            s += i

        return s


n = int(input())
my_calculator = Calculator()
s = my_calculator.divisorSum(n)
print("I implemented: " + type(my_calculator).__bases__[0].__name__)
print(s)