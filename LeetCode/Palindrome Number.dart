bool isPalindrome(int x) => x.toString().split('').reversed.join() == x.toString();

main() {
  print(isPalindrome(-121));
}