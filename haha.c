#include <stdio.h>
#include <math.h>

int main() {
    double s = 0, t = 0;
    double h = 0.0000001;
    for(int i = 1; i < 10000000; ++i) {
        double x = h * i;
        if(i % 2 == 0) {
            t += 2.0 * pow(x, x);
        } else {
            t += 4.0 * pow(x, x);
        }
    }
    for(int i = 1; i < 20; ++i) {
        if(i % 2 == 0) {
            s -= 1.0 / pow(i, i);
        } else {
            s += 1.0 / pow(i, i);
        }
    }
    printf("val = %.15lf\n", h / 3.0 * (2 + t));
    printf("val = %.15lf\n", s);
}