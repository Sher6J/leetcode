//编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。 
//
// 示例： 
//
// +----+---------+
//| Id | Email   |
//+----+---------+
//| 1  | a@b.com |
//| 2  | c@d.com |
//| 3  | a@b.com |
//+----+---------+
// 
//
// 根据以上输入，你的查询应返回以下结果： 
//
// +---------+
//| Email   |
//+---------+
//| a@b.com |
//+---------+
// 
//
// 说明：所有电子邮箱都是小写字母。 
// 👍 246 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：查找重复的电子邮箱
public class P182DuplicateEmails{
    public static void main(String[] args) {
//        Solution solution = new P182DuplicateEmails().new Solution();
        // TO TEST
    }
    //There is no code of Java type for this problem
}

// SELECT Email
// FROM Person
// GROUP BY Email
// HAVING count(Email) > 1