def divide_conquer(problem, p1, p2,...):
    # recursion terminator
    if problem is None:
        print_result
        return
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0],p1,...)
    subresult2 = self.divide_conquer(subproblems[1],p1,...)
    subresult3 = self.divide_conquer(subproblems[2],p1,...)
    ...
    # process and generate the finnal result
    result = process_result(subresult1, subresult2, subresult3,...)

    # revert the current level states
    