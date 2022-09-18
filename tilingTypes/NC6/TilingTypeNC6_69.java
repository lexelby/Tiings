package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_69
   extends TilingType
{
   public TilingTypeNC6_69(){
      super( "NC6-69", 6, SymmetryType.cmm );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,100,100};
      paramDef = new int[]{ 50, 20, 30, 30};
      paramName = new String[]{"Aspect", "Relative Length", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,2, 0,2,5, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 5,2, 2,2,5, 0},

            {0, 0,1, 0,0,1, 1},
            {1, 5,2, 4,2,5, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 5,2, 6,2,5, 1},
      };
      info = "a=d\nc=e\nA+B+C=360\nC+D=360\n(D+E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;
      double ln1 = h * getParam(paramValues, 1)/100;
      double ln2 = h - ln1;

      double x = getParam(paramValues, 2)/100 * w;
      double y = getParam(paramValues, 3)/100 * h;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w, ln2);
      baseTile.setPoint(3,  w-x, h-y);
      baseTile.setPoint(4,  x,  y);
      baseTile.setPoint(5,  0, ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(0);
   }
}