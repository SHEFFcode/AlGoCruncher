def flatten_dictionary(dictionary):
    if not dictionary:
        return {}
    output_dictionary = {}
    directory_path = ''
    traverse_dictionary(dictionary, output_dictionary, directory_path)
    return output_dictionary

def traverse_dictionary(dictionary, output_dictionry, directory_path):
    for key in dictionary:
        if type(dictionary[key]) is not dict:
          update_key = directory_path + '.' + key if directory_path else key
          if update_key.endswith("."):
            update_key = update_key[:-1]
          output_dictionry.update({update_key: dictionary[key]})
        elif type(dictionary[key]) is dict:
          traverse_dictionary(dictionary[key], output_dictionry, directory_path + '.' + key if key and directory_path else key)

'''
case1 type(dictionary[key]) is dict :
    traverse_dictionary(dictionary[key], new_dictionary, directory_path + '.' + key if directory_path else key
case2 type(dictionary[key]) is not dict:
    new_dictionary.update({directory_path + '.' + key: dictionary[key]
'''

dictionary = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }
flatten_dictionary(dictionary)