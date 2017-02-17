from datetime import datetime

now = datetime.now()

print '%s/%s/%s %s:%s:%s' \
      % (now.month, now.day, now.year, now.hour, now.minute, now.second)

number1 = 6
number2 = 12
number3 = number1 % number2
print number3

n = raw_input("Enter an integer between 0 and 45: ")

while n < 0:
    "Enter an integer between 0 and 45: "
    n = raw_input("Invalid Choice. Enter an integer between 0 and 45: ")

if n == 0:
    print str(n)
elif n == 1:
    print str(0)
    print "1"
else:
    n_minus_1 = 1
    n_minus_2 = 0
    fiboNum = 0

    print n_minus_2
    print n_minus_1

    for num in range(1, n):
          fiboNum = n_minus_1 + n_minus_2
          n_minus_2 = n_minus_1
          n_minus_1 = fiboNum
          print fiboNum