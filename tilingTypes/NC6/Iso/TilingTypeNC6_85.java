package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_85
   extends TilingType
{
   public TilingTypeNC6_85(){
      super( "NC6-85", 6, SymmetryType.cmm );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,100,100};
      paramDef = new int[]{ 40, 80, 30, 30};
      paramName = new String[]{"Aspect", "Relative Length 2", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,2, 0,2,5, 0},
            {0, 0,1, 0,0,1, 1},
            {0, 5,2, 2,2,5, 1},
      };
      info = "d=f\nA=90\nB=90\nD+E=360\n(C+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln1 = lntotal * getParam(paramValues,0)/100;
      double ln23 = lntotal-ln1;
      double ln2 = ln23 * getParam(paramValues,1)/100;
      double ln3 = ln23-ln2;
      
      double x = ln1 * getParam(paramValues,2)/100;
      double y = ln23 * getParam(paramValues,3)/100;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln1,  0);
      baseTile.setPoint(2, ln1, ln2);
      baseTile.setPoint(3, ln1-x, ln23-y );
      baseTile.setPoint(4,  x,  y);
      baseTile.setPoint(5,  0, ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[3].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[3].getY(0);
   }
}