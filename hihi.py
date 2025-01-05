def f(x: float) -> float:
    return x ** x

x = 0
y = 1
h = 0.0000001
t = 0
k = 1 // h
for i in range(1, 10000000):
    if i % 2 == 0:
        t += 2 * f(i * h)
    else:
        t += 4 * f(i * h)
print(h / 3 * (1 + 1 + t))

s = 0
for i in range(1, 100000):
    if i % 2 == 0:
        s -= 1 / (i ** i)
    else:
        s += 1 / (i ** i)
print(s)