function solution(n) {
    if(n <= 1) return 1;
    
    var primeList = new Array();	
	primeList[0] = false;
	primeList[1] = false;
	
	for(let i = 2; i <= n; i++) primeList[i] = true;

	for(let i = 2; (i * i) <= n; i++){
		if(primeList[i]){
			for(let j = i * i; j <= n; j += i) primeList[j] = false;
		}
	}
    
    return primeList.filter(e => e).length;
}