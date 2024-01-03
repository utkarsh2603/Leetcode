class Solution {
    private int n;
    private int numDigits;
    private static ArrayList<Integer> primes;
    private static int lastChecked = 1;
    public int primePalindrome(int nInput) {
        n = nInput;
        if (n==1 || n==2){
            return 2;
        }
        if (n==4 || n==5){
            return 5;
        }
        if (primes == null){
            primes = new ArrayList<Integer>();
            primes.add(2);
        }
        numDigits = 1;
        while (n >= Math.pow(10, numDigits)){
            numDigits++;
        }
        if (numDigits%2 == 0 && n > 11){
            n = (int)Math.pow(10, numDigits)+1;
            numDigits++;
        }
        int msd = getDigit(numDigits);
        if (msd%2 == 0 || msd == 5){
            if (msd >= 4 && msd <= 6){
                msd = 7;
            } else {
                msd++;
            }
            n = msd;
            if (numDigits!=1){
                n+=msd * (int)Math.pow(10, numDigits-1);
            }
        } else {
            for (int i = (numDigits+1)/2; i > 0; i--){
                setDigit(i, getDigit(numDigits-i+1));
            }
            if (n < nInput){
                increment();
            }
        }
        while (!isPrime()){
            increment();
        }
        return n;
    }
    private int getDigit(int i) {
        return (n%(int)Math.pow(10, i))/(int)Math.pow(10, i-1);
    }
    private void setDigit(int i, int m) {
        int first = n-n%(int)Math.pow(10, numDigits-i+1);
        int middle = Math.max(0, n%(int)Math.pow(10, numDigits-i)
            - n%(int)Math.pow(10, i));
        int last = n%(int)Math.pow(10, i-1);
        n = first + middle + last + m*(int)Math.pow(10, i-1);
        if (i != numDigits-i+1){
            n += m*(int)Math.pow(10, numDigits-i);
        }
    }
    private void increment(){
        for (int i = (numDigits+1)/2; i > 0; i--){
            int curDigit = getDigit(i);
            if (i == 1 && curDigit == 9){
                if (numDigits == 1){
                    n = 11;
                    numDigits = 2;
                    return;
                } else {
                    n = (int)Math.pow(10, numDigits+1)+1;
                    numDigits+=2;
                    return;
                }
            } else if (curDigit == 9){
                setDigit(i, 0);
            } else {
                curDigit++;
                if (i == 1){
                    if (curDigit%2 == 0 || curDigit == 5){
                        if (curDigit >= 4 && curDigit <= 6){
                            curDigit = 7;
                        } else {
                            curDigit++;
                        }
                    }
                }
                setDigit(i, curDigit);
                return;
            }
        }
    }
    private boolean isPrime() {
        int end = (int)Math.sqrt(n);
        for (int i = lastChecked+2; i <= end; i+=2){
            if (isPrimeLookup(i)){
                primes.add(i);
            }
            lastChecked = i;
        }
        return isPrimeLookup(n);
    }
    private boolean isPrimeLookup(int m){
        int end = (int)Math.sqrt(m);
        for (int i = 0; i < primes.size() && primes.get(i) <= end; i++){
            if (m%primes.get(i) == 0){
                return false;
            }
        }
        return true;
    }
}