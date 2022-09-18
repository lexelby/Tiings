package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bh
   extends TilingType
{
   public TilingTypeN5_01bh(){
      super( "N5-1bh", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,1,0, 0},
            {2, 1,0, 1,2,3, 0},
            {1, 4,3, 2,1,2, 0},
            {0, 0,1, 3,1,0, 0},
            {2, 1,0, 4,2,3, 0},

            {1, 2,1, 5,3,2, 1},
            {0, 0,1, 6,1,0, 1},
            {2, 1,0, 7,2,3, 1},
            {1, 4,3, 8,1,2, 1},
            {0, 0,1, 9,1,0, 1},
            {2, 1,0,10,2,3, 1},
      };
      info = "b=d\nc=e\na+c=b\nA+B=180\nB=D\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .8;

      double lnbd = ln * getParam(paramValues, 0)/200;
      double lnac = ln - lnbd;
      double lne = lnac - lnbd;
      double diag = Math.sqrt(lnac*lnac + lnac*lnbd - 2*lnbd*lnbd); 

      double b = calcAngle(lnbd, lnac, diag);
      double c = 180-b + calcAngle(diag,diag,lne);
      
      double x2 = lnac + lnbd * Math.cos((180-b) * DEG2RAD);
      double y2 =        lnbd * Math.sin((180-b) * DEG2RAD);
      double x3 = x2   + lnac * Math.cos((-b-c) * DEG2RAD);
      double y3 = y2   + lnac * Math.sin((-b-c) * DEG2RAD);
      double x4 = x3   + lnbd * Math.cos((180-b-b-c) * DEG2RAD);
      double y4 = y3   + lnbd * Math.sin((180-b-b-c) * DEG2RAD);

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, lnac,  0);
      baseTile.setPoint(2,   x2, y2);
      baseTile.setPoint(3,   x3, y3);
      baseTile.setPoint(4,   x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(4)-tiles[2].getX(3);
      offsets[1] = tiles[5].getY(4)-tiles[2].getY(3);
      offsets[2] = tiles[11].getX(4)-tiles[3].getX(2);
      offsets[3] = tiles[11].getY(4)-tiles[3].getY(2);
   }
}
