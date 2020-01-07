package manageExcpetion;

/**
 * @author cj
 * @date 2020/1/7
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 思路：找出重点关注的地方分情况讨论
 * ∵ .表示任意字符，所以当模式中的某个字符为.或和字符串中的某字符相等时则匹配，进入下一个字符比较
 * 重点考虑*
 * 一般情况：
 * 当第二个字符为*时(第一个字符为*没有意义，划分问题规模)，可以选择三种情况
 *
 * 如果str第一个字符与pattern第一个字符相同或者pattern第一个字符为.，此时*和前面的字符匹配
 * 第一种：模式向后移动2个字符，字符串向后移动1个字符，继续匹配(比如aaa和a*a*a)
 * 第二种: 模式不移动，字符串向后移动一位，继续匹配* (比如aaa和a*)
 * 第三种：模式向后移动2个字符，*表示前面字符为0，相当于忽略*和前面的字符，字符串不移动(比如aaa和a*a*a*a)
 *
 * 如果str第一个字符与pattern第一个字符不相同，此时*和前面的字符不匹配
 * 模式向后移动两位，字符串向后移动一位，比较下一位，(比如aaa和b*a*b)
 *
 * ========================
 * 如果第二个字符不为*
 * 当第一个字符一样，可能匹配成功或者失败，进入递归
 * 如果第一个字符不一样，则必定失败(为*可以表示前一个字符出现0次)
 *========================
 * 找出base case(何时才算匹配成功)：
 * 当str和pattern都走到尾，表示pattern匹配str成功
 * 当str未走到尾，pattern已经走到尾，此时pattern匹配str失败，str还有剩余字符未匹配
 * 当str走到尾，pattern未走到尾，或str和pattern都未走到尾，此时可能匹配成功，也可能失败，进入一般情况。
 *
 */
public class Match {
    public static void main(String[] args) {
        char[] str = {'a', 'a', 'a'};
        char[] pattern = {'a', '*'};
        System.out.println(match(str, pattern));
    }

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(0, str, 0, pattern);
    }

    private static boolean matchCore(int strIndex, char[] str, int patternIndex, char[] pattern) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        // 注意保证数组下标不越界
        // 第二个字符为*
        if ((patternIndex + 1) < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex < str.length && str[strIndex] == pattern[patternIndex]) ||
                    (strIndex < str.length && pattern[patternIndex] == '.')) {
                return matchCore(strIndex, str, patternIndex + 2, pattern)
                        || matchCore(strIndex + 1, str, patternIndex + 2, pattern)
                        || matchCore(strIndex + 1, str, patternIndex, pattern);
            } else { // 第一个字符不匹配
                return matchCore(strIndex, str, patternIndex + 2, pattern);
            }
        }
        if ((strIndex < str.length && pattern[patternIndex] == str[strIndex])
            || (strIndex < str.length && pattern[patternIndex] == '.')) { // 第二个字符不为*,第一个字符匹配
               return matchCore(strIndex + 1, str, patternIndex + 1, pattern);
        }
        return false;
    }
}
