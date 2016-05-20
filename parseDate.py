import sys, getopt
import dateparser

def main(argv):
	date = ''
	
	try:
		opts, args = getopt.getopt(argv, "hi:o", ["date="])
	except getopt.GetoptError:
		print 'parseDate.py -d <Date>'
		sys.exit(2)
	for opt, arg in opts:
		if opt == '-h':
			print 'parseDate.py -d <Date>'
			sys.exit()
		elif opt in("-d", "--date"):
			date = arg
	

	import dateparser
	ddp = dateparser.date.DateDataParser(languages=['de'])
	print(ddp.get_date_data(date))
	
	
if __name__ == "__main__":
	main(sys.argv[1:])