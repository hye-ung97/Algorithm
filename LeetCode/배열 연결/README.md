# 1929. Concatenation of Array

- 난이도: Easy
- 출처: [LeetCode 문제 바로가기](https://leetcode.com/problems/concatenation-of-array/description/)
- 사용 언어: Java

## 문제 요약

길이가 `n`인 정수 배열 `nums`가 주어진다.

`nums`를 두 번 이어 붙여 길이가 `2n`인 새로운 배열 `ans`를 만들고 반환한다.

모든 `0 <= i < n`에 대해 다음 조건을 만족해야 한다.

```text
ans[i] = nums[i]
ans[i + n] = nums[i]
```

## 입출력 예시

### 예시 1

```text
입력: nums = [1, 2, 1]
출력: [1, 2, 1, 1, 2, 1]
```

### 예시 2

```text
입력: nums = [1, 3, 2, 1]
출력: [1, 3, 2, 1, 1, 3, 2, 1]
```

## 제약 조건

- `n == nums.length`
- `1 <= n <= 1000`
- `1 <= nums[i] <= 1000`

## 풀이 아이디어

결과 배열의 길이는 원본 배열의 두 배이다.

바깥쪽 반복문으로 원본 배열을 복사할 횟수인 두 번을 순회하고, 안쪽 반복문으로 `nums`의 각 원소를 결과 배열의 알맞은 위치에 저장한다.

두 번째 복사를 시작할 위치는 `nums.length`만큼 뒤이므로, 결과 배열의 인덱스는 다음과 같이 계산할 수 있다.

```text
nums.length * i + j
```

## 복잡도

- 시간 복잡도: `O(n)`
- 공간 복잡도: `O(n)` — 길이가 `2n`인 결과 배열을 생성한다.
