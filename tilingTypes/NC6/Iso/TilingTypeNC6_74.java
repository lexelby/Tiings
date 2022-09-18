package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_74
   extends TilingType
{
   public TilingTypeNC6_74(){
      super( "NC6-74", 6, SymmetryType.p6 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 50, 60, 40};
      paramName = new String[]{"Relative Length 1", "Relative Length 2", "Relative Length 3"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,5, 0},
            {0, 0,1, 1,0,5, 0},
            {0, 0,1, 2,0,5, 0},
            {0, 0,1, 3,0,5, 0},
            {0, 0,1, 4,0,5, 0},
      };
      info = "a=b\nd=e\nA=60\nD=120\nC+E=360\n(B+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double lnh = lntotal * getParam(paramValues,0)/100;
      double lnt = lntotal-lnh;
      
      final double s = Math.sqrt(3)/2;
      final double c = .5;
      
      double ln2 = (lnh + lnt) / 2 * getParam(paramValues,1)/100;
      double ln3 = (lnh+lnt-2*ln2) * getParam(paramValues,2)/100;
      
      double x5 = -lnh*c + ln2 + ln3;
      double y5 = lnh*s;
      double x4 = lnh*c + lnt-ln2;
      double y4 = y5;
      double x3 = (lnh+lnt)*c;
      double y3 = (lnh-lnt/3)*s;
      double x2 = x3 - (x4-x3)*c - (y4-y3)*s;
      double y2 = y3 + (x4-x3)*s - (y4-y3)*c;
      double x1 = (lnh+ln2+ln3)*c;
      double y1 = (lnh-ln2-ln3)*s;

      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[2].getX(3);
      offsets[1] = tiles[0].getY(3)-tiles[2].getY(3);
      offsets[2] = tiles[0].getX(3)-tiles[4].getX(3);
      offsets[3] = tiles[0].getY(3)-tiles[4].getY(3);
   }
}