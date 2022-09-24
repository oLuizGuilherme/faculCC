
class Historia:

    def __init__(self) -> None:
        self.id	#int	The unique ID of the story resource.
        self.title	#string	The story title.
        self.description	#string	A short description of the story.
        self.resourceURI	#string	The canonical URL identifier for this resource.
        self.type	#string	The story type e.g. interior story, cover, text story.
        self.modified	#Date	The date the resource was most recently modified.
        self.thumbnail	#Image	The representative image for this story.
        self.comics	#ComicList	A resource list containing comics in which this story takes place.
        self.series	#SeriesList	A resource list containing series in which this story appears.
        self.events	#EventList	A resource list of the events in which this story appears.
        self.characters	#CharacterList	A resource list of characters which appear in this story.
        self.creators	#CreatorList	A resource list of creators who worked on this story.
        self.originalissue	#ComicSummary	A summary representation of the issue in which this story was originally published.