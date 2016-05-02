#coding=UTF-8
from hubstorage import HubstorageClient
hc = HubstorageClient(auth='bc2aa25cc40f4ed4b03988e8e0b9e89e')
project = hc.get_project('53883')
itemslist = hc.get_job('53883/1/5').items.list()
itemslist_size = itemslist.__sizeof__()
for element in itemslist:
	element.__delitem__('_type')
	element.__delitem__('_cached_page_id')
	element.__delitem__('_template')
	elementIterator = element.iteritems()
	for fields in elementIterator:
		fieldIterator = fields.__iter__()
		for values in fieldIterator:
			if isinstance(values, basestring):
				print values
			else:
				print values.pop()