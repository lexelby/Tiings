package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_27b
   extends TilingType
{
   public TilingTypeNC5_27b(){
      super( "NC5-27b", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 4,3, 0,1,2, 0},
            {0, 1,0, 1,4,0, 0},
            {0, 0,4, 1,0,1, 0},

            {0, 3,4, 2,1,2, 1},
            {1, 0,1, 4,0,4, 1},
            {1, 4,3, 5,1,2, 1},
            {0, 1,0, 5,4,0, 1},
      };
      info = "c=e\nb=a+d\nA=90\nB=45\nC=135\nD=225\n(E=45)";
   }

   public void recalcBase(double[] paramValues) {
      double t = Math.sqrt(2)/2;
      double ln2 = 1.5 * paramValues[0] / 100;
      double ln3 = (1.5-ln2)*t;
      double ln4 = ln2 * t;

      double x1 = ln3+ln4;
      double y1 = -ln4-ln3;
      double x2 = ln3+ln4;
      double y2 = -ln3;
      double x3 = ln4;
      double y3 = 0;
      double x4 = ln4;
      double y4 = ln4;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(3)-tiles[0].getX(4);
      offsets[1] = tiles[7].getY(3)-tiles[0].getY(4);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(0);
   }
}
