//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：监控二叉树
public class P968BinaryTreeCameras{
    public static void main(String[] args) {
        Solution solution = new P968BinaryTreeCameras().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minCameraCover(TreeNode root) {
//        return methodf1Recursive(root);
        // 根节点没有父节点，则只比较 根节点有相机 和 根节点无相机被子节点监控 的相机数
        return Math.min(minCam(root)[0], minCam(root)[2]);
    }



    /**
     * 数组中保存3个状态，以当前节点为根的子树
     * 1. 当前节点有相机时最少的相机数
     * 2. 当前节点无相机但被父节点监控的最少相机数
     * 3. 当前节点无相机但被子节点监控的最少相机数
     * @param node
     * @return int[0] 当前节点有相机 int[1] 当前节点无相机被父节点监控 int[2] 当前节点无相机被子节点监控
     */
    public int[] minCam(TreeNode node) {
        if (node == null) { // base case
            // 空节点被要求有相机，但其不可能有相机
            return new int[] {2000, 0, 0};
        }
        int[] left = minCam(node.left);
        int[] right = minCam(node.right);
        int[] cur = new int[3];
        cur[0] = 1 + min( // 当前节点有相机，相机数 + 1，则孩子有无相机均可
                left[1] + right[1], // 左、右孩子都没有相机且被父亲监控
                left[0] + right[1], // 左孩子有相机，右孩子没相机被父亲监控
                left[1] + right[0] // 右孩子有相机，左孩子没相机被父亲监控
        );
        cur[1] = min( // 当前节点无相机且被其父亲已监控，则孩子有无相机均可，但无相机必被其孩子监控
                left[0] + right[0], // 左、右孩子均有相机
                left[0] + right[2], // 左有相机、右孩子无相机被孩子监控
                left[2] + right[0], // 右有相机、左孩子无相机被孩子监控
                left[2] + right[2] // 左、右孩子均无相机被孩子监控
        );
        cur[2] = min( // 当前节点无相机且被其孩子监控，则孩子中必有一个有相机，没有相机的则被其孩子监控
                left[0] + right[2],
                left[2] + right[0],
                left[0] + right[0]
        );
        return cur;
    }


    private int methodf1Recursive(TreeNode root) {
        return Math.min(
                // 根节点安放摄像头，则根节点监控自己
                minCamNum(root, true, true),
                // 根节点不安放摄像头，则根节点不监控自己，根节点没有父节点
                minCamNum(root, false, false)
        );
    }

    /**
     * 法一：递归，超时，通过 160 / 170 个通过测试用例
     * 返回当前节点为根的子树需要的最少摄像头数
     * @param node 当前节点
     * @param isPlaceCam 是否安放摄像头
     * @param isWatched 是否被父亲或自己监控，即父亲安放摄像头或自己安放摄像头
     * @return
     */
    public int minCamNum(TreeNode node, boolean isPlaceCam, boolean isWatched) {
        if (node == null) {
            // 父节点要求自己安放摄像头，但空节点不可能安放，返回大于节点总数的数
            if (isPlaceCam) {
                return 2000;
            } else {
                return 0;
            }
        }
        if (isPlaceCam) { // 当前节点需要放置摄像头
            return 1 + min( // 当前放置了摄像头，故摄像头数 + 1
                    // 左孩子不放，但是被父亲监控；右孩子不放，但是被父亲监控
                    minCamNum(node.left, false, true) + minCamNum(node.right, false, true),
                    // 左孩子放，被父亲和自己监控；右孩子不放，但是被父亲监控
                    minCamNum(node.left, true, true) + minCamNum(node.right, false, true),
                    // 左孩子不放，但是被父亲监控；右孩子放，被付清和自己监控
                    minCamNum(node.left, false, true) + minCamNum(node.right, true, true)
            );
        } else { // 当前节点不需要放置摄像头
            if (isWatched) { // 当前节点被父亲监控
                return min(
                        // 左孩子放摄像头且被自己监控；右孩子放摄像头且被自己监控
                        minCamNum(node.left, true, true) + minCamNum(node.right, true, true),
                        // 左孩子放摄像头且被自己监控；右孩子不放摄像头由其孩子监控
                        minCamNum(node.left, true, true) + minCamNum(node.right, false, false),
                        // 左孩子不放摄像头由其孩子监控；右孩子放摄像头被自己监控
                        minCamNum(node.left, false, false) + minCamNum(node.right, true, true),
                        // 左右孩子均不放摄像头，均由其孩子监控
                        minCamNum(node.left, false, false) + minCamNum(node.right, false, false)
                );
            } else { // 当前节点不被父亲和自己监控，希望由其孩子监控
                return min(
                        // 左右孩子均放摄像头，且监控自己
                        minCamNum(node.left, true, true) + minCamNum(node.right, true, true),
                        // 左孩子不放，右孩子放
                        minCamNum(node.left, false, false) + minCamNum(node.right, true, true),
                        // 左孩子放，右孩子不放
                        minCamNum(node.left, true, true) + minCamNum(node.right, false, false)
                );
            }
        }
    }

    public int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

    public int min(int x, int y, int z, int w) {
        return Math.min(min(x, y, z), w);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}