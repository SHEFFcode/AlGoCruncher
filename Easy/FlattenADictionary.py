def flatten_dictionary(dictionary):
    new_dictionary = {}
    go_deeper(dictionary, new_dictionary, '')

    return new_dictionary

def go_deeper(new_dictionary, dictionary, full_name):


    for key in new_dictionary:
        # if not full_name:
        #     full_name = key
        if type(new_dictionary[key]) is not dict:
            if '.' in full_name:
                dictionary.update({full_name + '.' + key: new_dictionary[key]})
            else:
                dictionary.update({key: new_dictionary[key]})
        else:
            if not full_name:
                full_name = ''
            else:
                full_name += '.'
            go_deeper(new_dictionary[key], dictionary, full_name + '.' + key)

print(flatten_dictionary({
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : "1"
                }
            }
        }
))