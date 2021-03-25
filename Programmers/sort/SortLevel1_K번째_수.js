function solution(array, commands) {
    var answer = [];
    
    for(const i of commands) {
        var arr = array.slice(i[0] - 1, i[1]);
        arr.sort((a, b) => a - b);
        answer.push(arr[i[2] - 1]);
    }
    
    return answer;
}