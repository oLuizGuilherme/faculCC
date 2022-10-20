
class JsonUtils:

    def _json_object_hook(d): 
        return namedtuple('X', d.keys())(*d.values())

    @staticmethod
    def json2obj(data): 
        return json.loads(data, object_hook=_json_object_hook)
