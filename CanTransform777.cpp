#include <string>
#include <iostream>

using namespace std;

class CanTransform777 {
public:
    bool canTransform(string start, string end) {
        int index = 0;
        int offsetL = 0, offsetR = 0;
        while (index < start.length())
        {
            char s = start[index];
            char e = end[index];
            if (s == e)
            {
                if ((s == 'L' && offsetR != 0) || (s == 'R' && offsetL != 0))
                {
                    return false;
                }
                index++;
                continue;
            }
            if ((s == 'L' && e == 'R') || (s == 'R' && e == 'L'))
            {
                return false;
            }
            switch (s)
            {
                case 'X':
                    if (e == 'L')
                    {
                        offsetL--;
                    }else {
                        offsetR++;
                    }
                    break;
                case 'R':
                    offsetR--;
                    break;
                case 'L':
                    offsetL++;
                    break;
                default:
                    break;
            }
            if (offsetR > 0 || offsetL > 0 || (offsetR != 0 && offsetL != 0))
            {
                return false;
            }
            index++;
        }
        if (offsetL == 0 && offsetR == 0)
        {
            return true;
        }
        return false;
    }
};

int main() {
    CanTransform777 transform;
    cout << transform.canTransform("X", "L") << endl;
}