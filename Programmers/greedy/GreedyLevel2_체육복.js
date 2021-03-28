function solution(n, lost, reserve) {
    var answer = 0;
    var arr = []
    
    for(var i = 1; i <= n; i++){
        arr.push(1)
        if(reserve.includes(i)) arr[i - 1]++
        if(lost.includes(i)) arr[i - 1]--
    }

    for(var i = 0; i < n; i++){
       if(arr[i] == 0){
           if(arr[i - 1] == 2){
                arr[i]++
                arr[i - 1]--
           } else if(arr[i + 1] == 2){
               arr[i]++
               arr[i + 1]--
           }
       }
    }
    
    arr.forEach(e => { if(e >= 1) answer++ });
    return answer;
}