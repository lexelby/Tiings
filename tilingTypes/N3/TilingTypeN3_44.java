package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_44
   extends TilingType
{
   public TilingTypeN3_44(){
      super( "N3-44", 5, SymmetryType.p2 );
      // params are angle/distance of the other two points relative to first one
      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 20, 40};
      paramName = new String[]{ "Aspect", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {3, 0,4, 1,0,4, 1},
            {3, 4,1, 2,1,4, 1},
            {1, 4,0, 3,4,0, 0},
            {0, 2,1, 4,1,2, 0},
            {2, 4,0, 5,0,4, 0},
            {2, 3,1, 6,1,3, 0},
      };
      info = "A=90\n(B+C=90)";
      labels = new int[]{0,1,-1,-1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*getParam(paramValues,0)/100.;
      double ln1 = 2-ln2;
      double os1 = getParam(paramValues,1)/100.;
      double os2 = getParam(paramValues,2)/100.;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2, ln1*os1, ln2*(1-os1));
      baseTile.setPoint(3, ln1*os2, ln2*(1-os2));
      baseTile.setPoint(4,   0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[7].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(4);
   }
}
