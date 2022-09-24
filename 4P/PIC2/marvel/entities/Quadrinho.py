
class Quadrinho:

    def __init__(self):
        self.id	#int	The unique ID of the comic resource.
        self.digitalId	#int	The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.
        self.title	#string	The canonical title of the comic.
        self.issueNumber	#int	The number of the issue in the series (will generally be 0 for collection formats).
        self.variantDescription	#string	If the issue is a variant (e.g. an alternate cover, second printing, or director's cut), a text description of the variant.
        self.description	#string	The preferred description of the comic.
        self.modified	#Date	The date the resource was most recently modified.
        self.isbn	#string	The ISBN for the comic (generally only populated for collection formats).
        self.upc	#string	The UPC barcode number for the comic (generally only populated for periodical formats).
        self.diamondCode	#string	The Diamond code for the comic.
        self.ean	#string	The EAN barcode for the comic.
        self.issn	#string	The ISSN barcode for the comic.
        self.format	#string	The publication format of the comic e.g. comic, hardcover, trade paperback.
        self.pageCount	#int	The number of story pages in the comic.
        self.textObjects	#Array[TextObject]	A set of descriptive text blurbs for the comic.
        self.resourceURI	#string	The canonical URL identifier for this resource.
        self.urls	#Array[Url]	A set of public web site URLs for the resource.
        self.series	#SeriesSummary	A summary representation of the series to which this comic belongs.
        self.variants	#Array[ComicSummary]	A list of variant issues for this comic (includes the "original" issue if the current issue is a variant).
        self.collections	#Array[ComicSummary]	A list of collections which include this comic (will generally be empty if the comic's format is a collection).
        self.collectedIssues	#Array[ComicSummary]	A list of issues collected in this comic (will generally be empty for periodical formats such as "comic" or "magazine").
        self.dates	#Array[ComicDate]	A list of key dates for this comic.
        self.prices	#Array[ComicPrice]	A list of prices for this comic.
        self.thumbnail	#Image	The representative image for this comic.
        self.images	#Array[Image]	A list of promotional images associated with this comic.
        self.creators	#ResourceList	A resource list containing the creators associated with this comic.
        self.characters	#ResourceList	A resource list containing the characters which appear in this comic.
        self.stories	#ResourceList	A resource list containing the stories which appear in this comic.
        self.events	#ResourceList	A resource list containing the events in which this comic appears.