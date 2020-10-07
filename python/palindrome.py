def valid_palindrome_naive(string: str) -> bool:
    return string == string[::-1]


def valid_palindrome(string: str) -> bool:
    length = len(string)

    if length < 2:
        return True

    start = 0
    end = length - 1

    normalized_string = string.lower()

    while start < end:
        if not normalized_string[start].isalnum():
            start += 1
            continue

        if not normalized_string[end].isalnum():
            end -= 1
            continue

        if normalized_string[start] is not normalized_string[end]:
            return False

        start += 1
        end -= 1

    return True
