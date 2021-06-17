A = [5, 2, 4, 6, 3, 7]
B = [5, 8 ,4 ,55, 64, 321, 3, 512, 2 , 4, 8, 15]
C = [7,25,52,54,64,21,52,4,8,9]

def solution(A):
    
	min1 = 9223372036854775807
	min2 = 9223372036854775807

	for i in range(1,len(A)-1):
		if A[i] < min1:
			min2 = min1
			min1 = A[i]
		elif A[i] < min2:
			min2 = A[i]

		print("min1, min2 : {}, {}".format(min1,min2))

solution(C)