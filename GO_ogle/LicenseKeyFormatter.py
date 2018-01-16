class Solution(object):
    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        license_key_characters = S.upper().replace('-', '')
        if len(license_key_characters) < 1:
            return ""
        first_group_length = K if len(license_key_characters) % K == 0 else len(license_key_characters) % K
        subsiquent_groups = license_key_characters[first_group_length:]
        subsiquent_groups_string = '-'.join([subsiquent_groups[i:i+K] for i in range(0, len(subsiquent_groups), K)])
        formatted_key = license_key_characters[:first_group_length] + '-' + subsiquent_groups_string
        return formatted_key.rstrip('-')

solution = Solution()
print(solution.licenseKeyFormatting("r", 2))
