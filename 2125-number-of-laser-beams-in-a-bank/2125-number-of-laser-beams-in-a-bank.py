class Solution(object):
    def numberOfBeams(self, bank):
        """
        :type bank: List[str]
        :rtype: int
        """
        beams = 0
        prevLaser = 0

        for i in bank:
            # count how many devices in the current row
            laser = i.count('1')
            
            # only connect to previous active row if current has devices
            if laser:
                beams += prevLaser * laser
                prevLaser = laser

        return beams