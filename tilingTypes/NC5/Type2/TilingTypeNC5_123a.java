package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_123a
   extends TilingType
{
   public TilingTypeNC5_123a(){
      super( "NC5-123a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 75};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,1, 1},
            {1, 1,2, 1,2,1, 1},
            {0, 0,1, 2,4,0, 0},

            {0, 3,4, 0,1,2, 1},
            {1, 4,0, 4,0,1, 0},
            {1, 1,2, 5,2,1, 0},
            {0, 0,1, 6,4,0, 1},
      };
      info = "a=b\nc=d=e\nA+E=180\nC+E=360\n(A+B+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double ln2 = lntotal * getParam(paramValues, 0)/200;
      double ln1 = lntotal - ln2;

      double dx = 2*ln1*(ln1-ln2);
      dx = ln1 * (dx-ln2*ln2)/(dx+2*ln2*ln2);
      double dy = Math.sqrt(ln1*ln1-dx*dx);
      
      double x1 = ln1;
      double y1 = 0;
      double x4 = dx; 
      double y4 = dy;
      double x3 = x4+ln2; 
      double y3 = y4;
      double x2 = x3 - ln2 /2; 
      double y2 = y3 - ln2 * Math.sqrt(3)/2;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[1].getX(3);
      offsets[1] = tiles[1].getY(1)-tiles[1].getY(3);
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(3);
   }
}
