class Solution(object):
    def addBoldTag(self, s, dict):
        """
        :type s: str
        :type dict: List[str]
        :rtype: str
        """
        start, end = 0, 0
        i, j = 0, 0
        stringList = []
        for i in range(0, len(s)):
            j = i + 1
            if s[:i + len(s) - 1] in dict and i < end:
                end = i + len(s) - 1
            if s[:i + len(s) - 1] in dict and i > end:
                stringList.append((start, end))
