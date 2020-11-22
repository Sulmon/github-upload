public class Hanoi{

	public static String solve(int n, String start, String spare, String target, HanoiRecCheck hrc) {
		
		hrc.checkRecHanoi();
		String res = "";
		if (n<1) return res; 
		if (n==1) {
			//System.out.println(start+"->"+target);

			
			//this one is for recursion depth
			solve(n-1, null, null, null, hrc);
			//this one is for recursion width.
			solve(n-1, null, null, null, hrc); 
			// whatever bro, we're done here.
			return start+"->"+target;
		}
		res += solve(n-1, start, target, spare, hrc) + " ";
		res += start+"->"+target+" ";
		//System.out.println(start+"->"+target);
		res += solve(n-1, spare, start, target, hrc) + " ";
		return res;
	}

}

