using System.Text;
using System.Collections;

public class Solution {
    public int Reverse(int x) {
        long reversedInt = 0;
        
        while(x != 0){
            reversedInt = reversedInt*10 + x%10;
            x = x/10;
        }
        
        if(reversedInt > Int32.MaxValue || reversedInt < Int32.MinValue) return 0;
 
        return (int)reversedInt;
    }
}


/*
G: int
O: int in with reversed digits
T: Any
S: Any

Notes: 
* 32 bit int
* returns 0 when int overflows, if tryparseint fails, then we return 0

Solution:

i: 120  => first path is to do trimend of 0 character
1: 12 => set up 2 pointers, and do a swap
   *^  (string[i], string[j]) = (string[j], string[i]) the iteration will stop when i == j or i > j something like that

*/