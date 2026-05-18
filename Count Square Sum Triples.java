public class Count Square Sum Triples {
     public int countTriples(int n) {
        int count=0;
        for(int i=2;i<=n;i++){
            for(int j=2;j<=n;j++){
                for(int k=2;k<=n;k++){
                    if(i*i+j*j==k*k){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
}
