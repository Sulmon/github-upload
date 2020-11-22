
public class Negafibonacci {
	
	public static int negaFibo(int n, NegaFiboRecCheck nfrc) {
		
		nfrc.nfrc();
	
	if (n<0)
		return (int) (Math.pow(-1, n+1)*negaFibo(-n, nfrc));
	if(n==0)
		return 0;
	if (n<2)
		return 1; 
	else 
		return negaFibo(n - 1, nfrc) + negaFibo(n - 2, nfrc);
		
  }
}


